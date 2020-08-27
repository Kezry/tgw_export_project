package cn.woukfun.web.exception;

import org.springframework.stereotype.Component;
import org.springframework.web.servlet.HandlerExceptionResolver;
import org.springframework.web.servlet.ModelAndView;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@Component
public class CustomerExceptionHandler implements HandlerExceptionResolver {

    @Override
    public ModelAndView resolveException(HttpServletRequest request, HttpServletResponse response, Object handler, Exception ex) {
        //创建ModelAndView
        ModelAndView mv = new ModelAndView();
        mv.addObject("errMsg", ex.getMessage());
        mv.setViewName("error");
        return mv;
    }
}
