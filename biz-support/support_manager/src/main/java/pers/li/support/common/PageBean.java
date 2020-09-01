package pers.li.support.common;

import java.io.Serializable;
import java.util.List;


/**
 * 单例模式，封装好的分页实体bean
 * @author shenziming
 * @date 2014-7-31
 * @version 1.0
 * @param <T>
 */
public final class PageBean<T> implements Serializable{    
    private long currentPage;// 当前页   
    private long nextPage;//下一页
    private long lastPage;//上一页
    private long pageSize;// 每页显示条数    
    private long totalPage;// 总页数    
    private long totalRecord;// 总记录数    
    private List<T> dataList;// 分页数据   
    private boolean hashLastPage;//是否有上一页
    private boolean hashNextPage;//是否有下一页
    
    public PageBean() {    
    }    
    
    /*  
     * 初始化PageBean实例  
     */    
    private PageBean(final long pageSize, final long page, final long totalRecord) {    
        // 初始化每页显示条数    
        this.pageSize = pageSize;    
        // 设置总记录数    
        this.totalRecord = totalRecord;    
        // 初始化总页数    
        setTotalPage();    
        // 初始化当前页    
        setCurrentPage(page);    
    
    }    
    
    /*  
     * 外界获得PageBean实例  
     */    
    public static PageBean newPageBean(final long pageSize, final long page, final long totalRecord) {    
    
        return new PageBean(pageSize, page, totalRecord);    
    }    
    
    // 设置当前请求页    
    private void setCurrentPage(long page) {    
//        try {    
//            currentPage = Integer.parseInt(page);    
//    
//        } catch (java.lang.NumberFormatException e) {    
//            // 这里异常不做处理，当前页默认为1    
//            currentPage = 1;    
//        }  
    	currentPage = page;
        // 如果当前页小于第一页时，当前页指定到首页    
        if (currentPage < 1) {     
            currentPage = 1;
            lastPage = currentPage;            
            hashLastPage = false;
        }
        else{
        	hashLastPage = true;
        	lastPage = currentPage - 1;    
        }
    
        if (currentPage > totalPage) {     
            currentPage = totalPage;    
            hashNextPage = false;
            nextPage = currentPage;
        }
        else{
        	hashNextPage = true;
        	nextPage = currentPage + 1;
        }
    
    }    
    
    private void setTotalPage() {    
        if (totalRecord % pageSize == 0) {    
    
            totalPage = totalRecord / pageSize;    
        } else {    
            totalPage = totalRecord / pageSize + 1;    
        }    
    }    
    
    /*  
     * 获得当前页  
     */    
    public long getCurrentPage() {    
        return currentPage;    
    }    
    
    /*  
     * 获得总页数  
     */    
    public long getTotalPage() {    
        return totalPage;    
    
    }    
    
    /*  
     * 获得开始行数  
     */    
    public long getStartRow() {    
        return (currentPage - 1) * pageSize;    
    }    
    
    /*  
     * 获得结束行  
     */    
    public long getEndRow() {    
        return currentPage * pageSize;    
    }    
    
    /*  
     * 获得翻页数据  
     */    
    public List<T> getDataList() {    
        return dataList;    
    }    
    
    /*  
     * 设置翻页数据  
     */    
    public void setDataList(List<T> dataList) {    
        this.dataList = dataList;    
    }    
    
    //首页    
     public long getFirst() {    
        
    	 return 1;    
     }   
     
     // // 尾页    
     //    
      public long getLast() {    
         
     	 return totalPage;    
      }
    //    
    //上一页    
//        
//     public int getPrevious() {    
//        
//    	 return currentPage - 1;    
//     } 
      
//  	//    
//    // // 下一页    
//     public int getNext() {    
//        
//    	 return currentPage + 1;    
//     }    
    //   
     
     
    public long getNextPage() {
		return nextPage;
	}

	public void setNextPage(long nextPage) {
		this.nextPage = nextPage;
	}

	public long getLastPage() {
		return lastPage;
	}

	public void setLastPage(long lastPage) {
		this.lastPage = lastPage;
	}

	public boolean isHashLastPage() {
		return hashLastPage;
	}

	public void setHashLastPage(boolean hashLastPage) {
		this.hashLastPage = hashLastPage;
	}

	public boolean isHashNextPage() {
		return hashNextPage;
	}

	public void setHashNextPage(boolean hashNextPage) {
		this.hashNextPage = hashNextPage;
	}

	public long getPageSize() {
		return pageSize;
	}

	public void setPageSize(long pageSize) {
		this.pageSize = pageSize;
	}

	public long getTotalRecord() {
		return totalRecord;
	}

	public void setTotalRecord(long totalRecord) {
		this.totalRecord = totalRecord;
	}

	public void setTotalPage(long totalPage) {
		this.totalPage = totalPage;
	}

	@Override
	public String toString() {
		return "PageBean [currentPage=" + currentPage + ", nextPage="
				+ nextPage + ", lastPage=" + lastPage + ", pageSize="
				+ pageSize + ", totalPage=" + totalPage + ", totalRecord="
				+ totalRecord + ", dataList=" + dataList + ", hashLastPage="
				+ hashLastPage + ", hashNextPage=" + hashNextPage + "]";
	}

 
	
     
     
}   