package com.khuongduy.entity;

import java.util.List;

public class ObjCheck
{
		private int status;
		private String success;
		private String check;
		private List listResult;
		private Object obj;
		
		
		public Object getObj() {
			return obj;
		}
		public void setObj(Object obj) {
			this.obj = obj;
		}
		public List getListResult() {
			return listResult;
		}
		public void setListResult(List listResult) {
			this.listResult = listResult;
		}
		public String getCheck()
		{
			return check;
		}
		public void setCheck(String check)
		{
			this.check = check;
		}
		public int getStatus()
		{
			return status;
		}
		public void setStatus(int status)
		{
			this.status = status;
		}
		public String getSuccess()
		{
			return success;
		}
		public void setSuccess(String success)
		{
			this.success = success;
		}
}
