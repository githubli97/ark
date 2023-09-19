package com.ark.common.domain.tag;

import java.util.List;

/**
 * 标签资源模型.
 */
public interface TagEntity {
  /**
   * 获取标签列表.
   *
   * @return 标签列表
   */
  List<Tag> getTags();

  /**
   * 获取标签数量.
   *
   * @return 标签数量
   */
  int getTagCount();

  boolean containsTag(Tag tag);
}
