package com.jm.tracker.spring.security;

// handle 403 page
//@Component
//public class MyAccessDeniedHandler implements AccessDeniedHandler {
//
//	 
//	private static Logger logger = LoggerFactory.getLogger(MyAccessDeniedHandler.class);
//
//	    @Override
//	    public void handle(HttpServletRequest httpServletRequest,
//	                       HttpServletResponse httpServletResponse,
//	                       AccessDeniedException e) throws IOException, ServletException {
//
//	        Authentication auth
//	                = SecurityContextHolder.getContext().getAuthentication();
//
//	        if (auth != null) {
//	            logger.info("User '" + auth.getName()
//	                    + "' attempted to access the protected URL: "
//	                    + httpServletRequest.getRequestURI());
//	        }
//	        System.out.print("httpServletRequest.getContextPath(): " +httpServletRequest.getContextPath());
//	        httpServletResponse.sendRedirect(httpServletRequest.getContextPath() + "/login");
//
//	    }
//
//   
//}

public class MyAccessDeniedHandler {
}