package sejong.back.web.interceptor;

import lombok.extern.slf4j.Slf4j;
import org.springframework.web.servlet.HandlerInterceptor;
import sejong.back.web.SessionConst;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

@Slf4j
public class LoginCheckInterceptor implements HandlerInterceptor {

    @Override
    public boolean preHandle(HttpServletRequest request, HttpServletResponse response, Object handler) throws Exception {

        String requestURI = request.getRequestURI();

        log.info("인증 체크 인터셉터 실행 {}", requestURI);
        HttpSession session = request.getSession(false);//세션을 있는 그대로 가져온다.

        if (session == null || session.getAttribute(SessionConst.DB_KEY) == null) {//로그인 안된거면 로그인페이지로 리다이렉트
            log.info("미인증 사용자 요청");

            //TODO 이렇게 리다이렉트 시키는 부분들은 나중에 클라이언트 쪽 url로 바꿔야 할 듯 (ex. https://www.sejongcommunity.com/login?redirectURL=)
            response.sendRedirect("/login?redirectURI=" + requestURI);
            return false;// login화면으로 리다이렉트 시키고 이제 여기서 진행 종료한다.
        }

        return true;
    }

}
