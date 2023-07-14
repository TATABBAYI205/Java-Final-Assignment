package daofactory;

import dao.BlogDaoImpl;
import dao.IBlogDao;

public class BlogDaoFactory {
	//make constructor private to avoid object creation 
		private BlogDaoFactory() {} 
		
		private static IBlogDao blogDao = null;
		
		public static IBlogDao getBlogDao() {
			
			//singleton pattern code
			if(blogDao == null) {
				blogDao = new BlogDaoImpl();
			}
			return blogDao;
		}
}
