package com.ark.core.tag;

import com.ark.core.base.BaseDisableAble;
import com.ark.core.base.BaseNameAble;
import java.util.List;

/**
 * 标签领域.
 */
public interface Tag extends BaseNameAble, BaseDisableAble {
  /**
   * 获取资源列表.
   *
   * @return 资源列表
   */
  List<TagResource> getResources();

  /**
   * 获取标签描述.
   *
   * @return 标签描述
   */
  String getDescription();

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