package com.yaakoub.cryptocurrencymarket.security;

import javax.servlet.*;
import java.io.IOException;

public class MockAccessManagerAgent implements Filter {
   // private Logger log = LoggerFactory.getLogger(com.victorbuckservices.common.utils.web.filter.MockAccessManagerAgentFilter.class);
    public static final String USERNAME_RAN_PARAM = "usernameRan";
    public static final String USERNAME_RAV_PARAM = "usernameRav";
    private static String usernameRan;
    private static String usernameRav;

    public MockAccessManagerAgent() {
    }

    public void init(FilterConfig filterConfig) throws ServletException {
       /* this.log.warn("***********************************************************************************************");
        this.log.warn("*                  This filter must only be used for test purpose!!!!                         *");
        this.log.warn("*                  This filter must only be used for test purpose!!!!                         *");
        this.log.warn("*                  This filter must only be used for test purpose!!!!                         *");
        this.log.warn("*                  This filter must only be used for test purpose!!!!                         *");
        this.log.warn("*                  This filter must only be used for test purpose!!!!                         *");
        this.log.warn("*                  This filter must only be used for test purpose!!!!                         *");
        this.log.warn("*                  This filter must only be used for test purpose!!!!                         *");
        this.log.warn("*                  This filter must only be used for test purpose!!!!                         *");
        this.log.warn("*                  This filter must only be used for test purpose!!!!                         *");
        this.log.warn("*                  This filter must only be used for test purpose!!!!                         *");
        this.log.warn("*                  This filter must only be used for test purpose!!!!                         *");
        this.log.warn("*                  This filter must only be used for test purpose!!!!                         *");
        this.log.warn("*                  This filter must only be used for test purpose!!!!                         *");
        this.log.warn("*                  This filter must only be used for test purpose!!!!                         *");
        this.log.warn("***********************************************************************************************");*/
//        if (!OS.isFamilyWindows()) {
        //throw new ServletException("This filter cannot run on other than a windows operating system!!");
//        }
        if (filterConfig.getInitParameter("usernameRan") != null) {
            usernameRan = filterConfig.getInitParameter("usernameRan");
            if (filterConfig.getInitParameter("usernameRav") != null) {
                usernameRav = filterConfig.getInitParameter("usernameRav");
            } else {
               // this.log.error("No {} is defined, this is a mandatory parameter", "usernameRav");
                throw new ServletException("No usernameRav is defined, this is a mandatory parameter");
            }
        } else {
           // this.log.error("No {} is defined, this is a mandatory parameter", "usernameRan");
            throw new ServletException("No usernameRan is defined, this is a mandatory parameter");
        }
    }

    public void doFilter(ServletRequest request, ServletResponse response, FilterChain chain) throws IOException, ServletException {
        request.setAttribute(usernameRan, usernameRav);
        chain.doFilter(request, response);
    }

    public void destroy() {
    }

    public static String getUsernameRan() {
        return usernameRan;
    }

    public static void setUsernameRan(String usernameRan) {
        usernameRan = usernameRan;
    }

    public static String getUsernameRav() {
        return usernameRav;
    }

    public static void setUsernameRav(String usernameRav) {
        usernameRav = usernameRav;
    }
}
