package com.cecgw.cq.entity;

import lombok.Data;
import lombok.NoArgsConstructor;
import org.hibernate.annotations.GeneratorType;
import org.hibernate.annotations.GenericGenerator;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Table;
import java.util.Date;

/**
 * RFID解析表
 * @author 曹华鹏
 *
 */
@Entity
@Table(name = "T_RFID_ANALYZE")
@Data
@NoArgsConstructor
public class RFID_ANALYZE {
    @Id
    @GeneratedValue(generator = "timeID")
    @GenericGenerator(name = "timeID",strategy = "com.cecgw.cq.util.IdGen")
    private Long id;

	/**
	 * <tt>id</tt>属性的Getter方法.
	 *
	 * @return id
	 */
	public Long getId() {
		return id;
	}

	/**
	 * <tt>id</tt> 的Setter方法.
	 *
	 * @param id 成员变量的值被设置成 id
	 */
	public void setId(Long id) {
		this.id = id;
	}

	private Date time;
	private String readerip;
	private String c1;
	private String c2;
	private String eid;
	private String color;
	private String nature;
	private String plate;
	private String vehicle;
	private String localization;

}
