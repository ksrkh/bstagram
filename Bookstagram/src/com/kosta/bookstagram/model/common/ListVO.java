package com.kosta.bookstagram.model.common;
import java.util.ArrayList;

/**
 * 리스트 화면에 보여질 게시물 리스트와 페이징 정보 객체를 저장하는 클래스 
 * @author kosta-00-kangsa-001
 *
 * Generic클래스의 설명
 * 
 *	<?> : 모든 객체 자료형, 내부적으로는 Object로 인식
 *	<? super 객체자료형> : 명시된 객체자료형의 상위 객체, 내부적으로는 Object로 인식
 *	<? extends 객체자료형> : 명시된 객체 자료형을 상속한 하위객체, 내부적으로는 명시된 객체 자료형으로 인식
 *	<E> - Element
 *	<K> - Key
 *	<N> - Number
 *	<T> - Type
 *	<V> - Value
 *
 */
public class ListVO<E> {
	private ArrayList<E> list;
	private PagingBean pagingBean;
	public ListVO() {super();}
	
	public ListVO(ArrayList<E> list, PagingBean pagingBean) {
		super();
		this.list = list;
		this.pagingBean = pagingBean;
	}
	
	public ArrayList<E> getList() {
		return list;
	}
	
	public void setList(ArrayList<E> list) {
		this.list = list;
	}
	
	public PagingBean getPagingBean() {
		return pagingBean;
	}
	
	public void setPagingBean(PagingBean pagingBean) {
		this.pagingBean = pagingBean;
	}
	
	@Override
	public String toString() {
		return "ListVO [list=" + list + ", pagingBean=" + pagingBean + "]";
	}
	
}
