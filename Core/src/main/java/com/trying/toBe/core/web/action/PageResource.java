package com.trying.toBe.core.web.action;

import java.io.Serializable;
import java.util.List;

public class PageResource<T> implements Serializable
{
private static final long serialVersionUID = 8119418445224607913L;
private int pageNum;
private int pageCount;
private long total;
private List<T> list;


public List<?> getList() {
  return this.list;
}

public void setList(List<T> list) {
  this.list = list;
}

public int getPageNum() {
  return this.pageNum;
}

public void setPageNum(int pageNum) {
  this.pageNum = pageNum;
}

public int getPageCount() {
  return this.pageCount;
}

public void setPageCount(int pageCount) {
  this.pageCount = pageCount;
}

public long getTotal() {
  return this.total;
}

public void setTotal(long total) {
  this.total = total;
}

public int getOffset()
{
  return (this.pageNum - 1) * this.pageCount;
}

public int getLimit()
{
  return this.pageCount;
}
}
