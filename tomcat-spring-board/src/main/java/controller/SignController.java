package controller;

import jakarta.servlet.http.HttpSession;
import model.SignIn;
import model.SignUp;

import jakarta.servlet.ServletContext;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.ModelAndView;

@RestController
public class SignController {

    private final ServletContext servletContext;

    public SignController(ServletContext servletContext) {
        this.servletContext = servletContext;
    }

    @GetMapping("/sign-up")
    public ModelAndView signUp() {
        return new ModelAndView("sign-up");
    }

    @GetMapping("/sign-in")
    public ModelAndView signIn() {
        return new ModelAndView("sign-in");
    }

    @PostMapping("/sign-up")
    public ModelAndView signUp(@ModelAttribute SignUp signUp) {
        ModelAndView mav = new ModelAndView();

        // 중복 사용자 확인
        if (servletContext.getAttribute(signUp.getUsername()) != null) {
            mav.setViewName("sign-up"); // 기존 화면 유지
            mav.addObject("error", "이미 존재하는 사용자 이름입니다.");
            return mav;
        }

        // 사용자 저장
        servletContext.setAttribute(signUp.getUsername(), signUp);

        // 성공 시 루트로 리다이렉트
        mav.setViewName("redirect:/");
        return mav;
    }

    @PostMapping("/sign-in")
    public ModelAndView signIn(@ModelAttribute SignIn signIn, HttpSession session) {
        ModelAndView mav = new ModelAndView();

        // 사용자 확인
        SignUp registeredUser = (SignUp) servletContext.getAttribute(signIn.getUsername());
        if (registeredUser != null && registeredUser.getPassword().equals(signIn.getPassword())) {
            // 세션에 사용자 이름 저장
            session.setAttribute("userName", registeredUser.getName());
            mav.setViewName("redirect:/"); // 성공 시 루트로 리다이렉트
        } else {
            mav.setViewName("sign-in"); // 로그인 실패 시 화면 유지
            mav.addObject("error", "사용자 이름 또는 비밀번호가 잘못되었습니다.");
        }
        return mav;
    }

    @GetMapping("/sign-out")
    public ModelAndView logout(HttpSession session) {
        ModelAndView modelAndView = new ModelAndView("sign-out");
        modelAndView.addObject("userName", session.getAttribute("userName"));

        session.invalidate(); // 세션 무효화

        return modelAndView;
    }
}
