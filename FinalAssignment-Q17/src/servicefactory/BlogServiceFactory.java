package servicefactory;

import service.BlogServiceImpl;
import service.IBlogService;

public class BlogServiceFactory {
	//make constructor private to avoid object creation 
		private BlogServiceFactory() {} 
		
		private static IBlogService blogService = null;
		
		public static IBlogService getBlogService() {
			
			//singleton pattern code
			if(blogService == null) {
				blogService = new BlogServiceImpl();
			}
			return blogService;
		}
}
