package models;

import java.time.LocalDateTime;

import javax.persistence.Entity;
import javax.persistence.Id;

import com.avaje.ebean.Model;
import com.avaje.ebean.annotation.CreatedTimestamp;
import com.avaje.ebean.annotation.UpdatedTimestamp;

@Entity
public class Question extends Model {
	@Id
	public Long id;
	
	/**
	 * タイトル
	 */
	public String title;
	
	/**
	 * 質問者
	 * TODO: 外部キーの設定(User)
	 */
	public String questioner;
	
	/**
	 * 質問内容
	 */
	public String content;
	
	/**
	 * 作成日
	 */
	@CreatedTimestamp
	public LocalDateTime createdAt;
	
	/**
	 * 更新日
	 */
	@UpdatedTimestamp
	public LocalDateTime updatedAt;
}
