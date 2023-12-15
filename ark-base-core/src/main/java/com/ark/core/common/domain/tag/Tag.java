package com.ark.core.common.domain.tag;

import java.util.List;
import org.w3c.dom.Entity;

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