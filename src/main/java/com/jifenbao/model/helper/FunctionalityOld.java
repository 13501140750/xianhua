package com.jifenbao.model.helper;

import java.io.IOException;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import org.codehaus.jackson.JsonParseException;
import org.codehaus.jackson.map.JsonMappingException;
import org.codehaus.jackson.map.ObjectMapper;

import com.jifenbao.model.Menu;
import com.jifenbao.service.result.ResultHelper;

public class FunctionalityOld implements Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = -2214447862744731373L;

	/**
	 * 操作编码
	 */
	private String code;

	/**
	 * 操作名称
	 */
	private String name;

	/**
	 * 操作
	 */
	private String operation;
	/**
	 * 是否被选择
	 * 
	 * @return
	 */
	private boolean selected;
	
	public void setJsonString(String str){
		
	}

	public String getJsonString() {
		return "{\"code\":\"" + getCode() + "\",\"name\":\"" + getName() + "\",\"operation\":\"" + getOperation()
				+ "\"}";
	}

	public String getCode() {
		return code;
	}

	public void setCode(String code) {
		this.code = code;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	/**
	 * @return the operation
	 */
	public String getOperation() {
		return operation;
	}

	/**
	 * @param operation
	 *            the operation to set
	 */
	public void setOperation(String operation) {
		this.operation = operation;
	}

	/**
	 * @return the selected
	 */
	public boolean isSelected() {
		return selected;
	}

	/**
	 * @param selected
	 *            the selected to set
	 */
	public void setSelected(boolean selected) {
		this.selected = selected;
	}

	public static void main(String[] args) {
	    FunctionalityOld a = new FunctionalityOld();
		List<FunctionalityOld> list = new ArrayList<FunctionalityOld>();
		List<FunctionalityOld> list1 = new ArrayList<FunctionalityOld>();
		String jsonString = "[{\"code\":\"add\",\"name\":\"新增\",\"operation\":\"add\"},{\"code\":\"update\",\"name\":\"修改\",\"operation\":\"update\"},{\"code\":\"delete\",\"name\":\"删除\",\"operation\":\"delete\"},{\"code\":\"view\",\"name\":\"详情\",\"operation\":\"view\"}]";

		a.setCode("save");
		a.setName("新增");
		a.setOperation("save");
		list.add(a);

		System.out.println(ResultHelper.jasonString(list));
		System.out.println(a.getJsonString());
		list1 = ResultHelper.<FunctionalityOld> json2Object(jsonString);
		System.out.println(list1.size());
		System.out.println(list1.get(0));

		ObjectMapper mapper = new ObjectMapper();
		try {
		    FunctionalityOld[] listArray = mapper.readValue(jsonString, FunctionalityOld[].class);
			System.out.println(listArray.length);
			System.out.println(listArray[0]);
			System.out.println(listArray[0].getCode());
			System.out.println(listArray[0].getJsonString());

			Menu m = new Menu();
			List<FunctionalityOld> fList = Arrays.asList(listArray);
			//m.setFunctionalities(fList);
			
			System.out.println(m.getFunctions());
			System.out.println(ResultHelper.jasonString(fList));
			System.out.println("遍历 fList");
			for(FunctionalityOld f: fList){
				System.out.println(f.getJsonString());
			}
			
			listArray = mapper.readValue(m.getFunctions(), FunctionalityOld[].class);
		} catch (JsonParseException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (JsonMappingException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

	}

}
