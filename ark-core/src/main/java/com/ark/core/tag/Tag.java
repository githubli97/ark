package com.ark.core.tag;

import com.ark.core.ddd.Entity;
import java.util.List;

/**
 * 标签领域.
 */
public interface Tag extends Entity {

  /**
   * 获取资源列表.
   *
   * @return 资源列表
   */
  List<TagEntity> getResources();

  /**
   * 获取父标签.
   *
   * @return 父标签
   */
  Tag getParent();

  /**
   * 获取子标签.
   *
   * @return 子标签
   */
  List<Tag> getChildren();
}