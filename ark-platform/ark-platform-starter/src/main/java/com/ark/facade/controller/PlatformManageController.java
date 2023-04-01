package com.ark.facade.controller;

import lombok.AllArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

/**
 * 平台mvc接口.
 */
@Slf4j
@Controller
@AllArgsConstructor
public class PlatformManageController {

  /**
   * 菜单列表接口,打通前端时使用, 后期要加实现逻辑.
   */
  @GetMapping("menuList")
  public ResponseEntity menuList() {
    String menu = """
        [
          {
            "path": "/dashboard",
            "name": "Dashboard",
            "component": "LAYOUT",
            "redirect": "/dashboard/analysis",
            "meta": {
              "title": "routes.dashboard.dashboard",
              "hideChildrenInMenu": true,
              "icon": "bx:bx-home"
            },
            "children": [
              {
                "path": "analysis",
                "name": "Analysis",
                "component": "/dashboard/analysis/index",
                "meta": {
                  "hideMenu": true,
                  "hideBreadcrumb": true,
                  "title": "routes.dashboard.analysis",
                  "currentActiveMenu": "/dashboard",
                  "icon": "bx:bx-home"
                }
              },
              {
                "path": "workbench",
                "name": "Workbench",
                "component": "/dashboard/workbench/index",
                "meta": {
                  "hideMenu": true,
                  "hideBreadcrumb": true,
                  "title": "routes.dashboard.workbench",
                  "currentActiveMenu": "/dashboard",
                  "icon": "bx:bx-home"
                }
              }
            ]
          },
          {
            "path": "/permission",
            "name": "Permission",
            "component": "LAYOUT",
            "redirect": "/permission/front/page",
            "meta": {
              "icon": "carbon:user-role",
              "title": "routes.demo.permission.permission"
            },
            "children": []
          },
          {
            "path": "/level",
            "name": "Level",
            "component": "LAYOUT",
            "redirect": "/level/menu1/menu1-1",
            "meta": {
              "icon": "carbon:user-role",
              "title": "routes.demo.level.level"
            },
            "children": [
              {
                "path": "menu1",
                "name": "Menu1Demo",
                "meta": {
                  "title": "Menu1"
                },
                "children": [
                  {
                    "path": "menu1-1",
                    "name": "Menu11Demo",
                    "meta": {
                      "title": "Menu1-1"
                    },
                    "children": [
                      {
                        "path": "menu1-1-1",
                        "name": "Menu111Demo",
                        "component": "/demo/level/Menu111",
                        "meta": {
                          "title": "Menu111"
                        }
                      }
                    ]
                  },
                  {
                    "path": "menu1-2",
                    "name": "Menu12Demo",
                    "component": "/demo/level/Menu12",
                    "meta": {
                      "title": "Menu1-2"
                    }
                  }
                ]
              },
              {
                "path": "menu2",
                "name": "Menu2Demo",
                "component": "/demo/level/Menu2",
                "meta": {
                  "title": "Menu2"
                }
              }
            ]
          },
          {
            "path": "/system",
            "name": "System",
            "component": "LAYOUT",
            "redirect": "/system/account",
            "meta": {
              "icon": "ion:settings-outline",
              "title": "routes.demo.system.moduleName"
            },
            "children": [
              {
                "path": "account",
                "name": "AccountManagement",
                "meta": {
                  "title": "routes.demo.system.account",
                  "ignoreKeepAlive": true
                },
                "component": "/demo/system/account/index"
              },
              {
                "path": "account_detail/:id",
                "name": "AccountDetail",
                "meta": {
                  "hideMenu": true,
                  "title": "routes.demo.system.account_detail",
                  "ignoreKeepAlive": true,
                  "showMenu": false,
                  "currentActiveMenu": "/system/account"
                },
                "component": "/demo/system/account/AccountDetail"
              },
              {
                "path": "role",
                "name": "RoleManagement",
                "meta": {
                  "title": "routes.demo.system.role",
                  "ignoreKeepAlive": true
                },
                "component": "/demo/system/role/index"
              },
              {
                "path": "menu",
                "name": "MenuManagement",
                "meta": {
                  "title": "routes.demo.system.menu",
                  "ignoreKeepAlive": true
                },
                "component": "/demo/system/menu/index"
              },
              {
                "path": "dept",
                "name": "DeptManagement",
                "meta": {
                  "title": "routes.demo.system.dept",
                  "ignoreKeepAlive": true
                },
                "component": "/demo/system/dept/index"
              },
              {
                "path": "changePassword",
                "name": "ChangePassword",
                "meta": {
                  "title": "routes.demo.system.password",
                  "ignoreKeepAlive": true
                },
                "component": "/demo/system/password/index"
              }
            ]
          },
          {
            "path": "/link",
            "name": "Link",
            "component": "LAYOUT",
            "meta": {
              "icon": "ion:tv-outline",
              "title": "routes.demo.iframe.frame"
            },
            "children": [
              {
                "path": "doc",
                "name": "Doc",
                "meta": {
                  "title": "routes.demo.iframe.doc",
                  "frameSrc": "https://vvbin.cn/doc-next/"
                }
              },
              {
                "path": "https://vvbin.cn/doc-next/",
                "name": "DocExternal",
                "component": "LAYOUT",
                "meta": {
                  "title": "routes.demo.iframe.docExternal"
                }
              }
            ]
          }
        ]
        """;

    return ResponseEntity.status(HttpStatus.OK).contentType(MediaType.APPLICATION_JSON)
        .body(menu);
  }
}
