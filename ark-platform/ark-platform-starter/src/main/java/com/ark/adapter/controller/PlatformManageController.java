package com.ark.adapter.controller;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

import java.util.Map;

@Slf4j
@Controller
public class PlatformManageController {
    @Autowired
    private ObjectMapper objectMapper;
    @GetMapping("menuList")
    public ResponseEntity menuList() {
            String menu = "[\n" +
                    "  {\n" +
                    "    \"path\": \"/dashboard\",\n" +
                    "    \"name\": \"Dashboard\",\n" +
                    "    \"component\": \"LAYOUT\",\n" +
                    "    \"redirect\": \"/dashboard/analysis\",\n" +
                    "    \"meta\": {\n" +
                    "      \"title\": \"routes.dashboard.dashboard\",\n" +
                    "      \"hideChildrenInMenu\": true,\n" +
                    "      \"icon\": \"bx:bx-home\"\n" +
                    "    },\n" +
                    "    \"children\": [\n" +
                    "      {\n" +
                    "        \"path\": \"analysis\",\n" +
                    "        \"name\": \"Analysis\",\n" +
                    "        \"component\": \"/dashboard/analysis/index\",\n" +
                    "        \"meta\": {\n" +
                    "          \"hideMenu\": true,\n" +
                    "          \"hideBreadcrumb\": true,\n" +
                    "          \"title\": \"routes.dashboard.analysis\",\n" +
                    "          \"currentActiveMenu\": \"/dashboard\",\n" +
                    "          \"icon\": \"bx:bx-home\"\n" +
                    "        }\n" +
                    "      },\n" +
                    "      {\n" +
                    "        \"path\": \"workbench\",\n" +
                    "        \"name\": \"Workbench\",\n" +
                    "        \"component\": \"/dashboard/workbench/index\",\n" +
                    "        \"meta\": {\n" +
                    "          \"hideMenu\": true,\n" +
                    "          \"hideBreadcrumb\": true,\n" +
                    "          \"title\": \"routes.dashboard.workbench\",\n" +
                    "          \"currentActiveMenu\": \"/dashboard\",\n" +
                    "          \"icon\": \"bx:bx-home\"\n" +
                    "        }\n" +
                    "      }\n" +
                    "    ]\n" +
                    "  },\n" +
                    "  {\n" +
                    "    \"path\": \"/permission\",\n" +
                    "    \"name\": \"Permission\",\n" +
                    "    \"component\": \"LAYOUT\",\n" +
                    "    \"redirect\": \"/permission/front/page\",\n" +
                    "    \"meta\": {\n" +
                    "      \"icon\": \"carbon:user-role\",\n" +
                    "      \"title\": \"routes.demo.permission.permission\"\n" +
                    "    },\n" +
                    "    \"children\": []\n" +
                    "  },\n" +
                    "  {\n" +
                    "    \"path\": \"/level\",\n" +
                    "    \"name\": \"Level\",\n" +
                    "    \"component\": \"LAYOUT\",\n" +
                    "    \"redirect\": \"/level/menu1/menu1-1\",\n" +
                    "    \"meta\": {\n" +
                    "      \"icon\": \"carbon:user-role\",\n" +
                    "      \"title\": \"routes.demo.level.level\"\n" +
                    "    },\n" +
                    "    \"children\": [\n" +
                    "      {\n" +
                    "        \"path\": \"menu1\",\n" +
                    "        \"name\": \"Menu1Demo\",\n" +
                    "        \"meta\": {\n" +
                    "          \"title\": \"Menu1\"\n" +
                    "        },\n" +
                    "        \"children\": [\n" +
                    "          {\n" +
                    "            \"path\": \"menu1-1\",\n" +
                    "            \"name\": \"Menu11Demo\",\n" +
                    "            \"meta\": {\n" +
                    "              \"title\": \"Menu1-1\"\n" +
                    "            },\n" +
                    "            \"children\": [\n" +
                    "              {\n" +
                    "                \"path\": \"menu1-1-1\",\n" +
                    "                \"name\": \"Menu111Demo\",\n" +
                    "                \"component\": \"/demo/level/Menu111\",\n" +
                    "                \"meta\": {\n" +
                    "                  \"title\": \"Menu111\"\n" +
                    "                }\n" +
                    "              }\n" +
                    "            ]\n" +
                    "          },\n" +
                    "          {\n" +
                    "            \"path\": \"menu1-2\",\n" +
                    "            \"name\": \"Menu12Demo\",\n" +
                    "            \"component\": \"/demo/level/Menu12\",\n" +
                    "            \"meta\": {\n" +
                    "              \"title\": \"Menu1-2\"\n" +
                    "            }\n" +
                    "          }\n" +
                    "        ]\n" +
                    "      },\n" +
                    "      {\n" +
                    "        \"path\": \"menu2\",\n" +
                    "        \"name\": \"Menu2Demo\",\n" +
                    "        \"component\": \"/demo/level/Menu2\",\n" +
                    "        \"meta\": {\n" +
                    "          \"title\": \"Menu2\"\n" +
                    "        }\n" +
                    "      }\n" +
                    "    ]\n" +
                    "  },\n" +
                    "  {\n" +
                    "    \"path\": \"/system\",\n" +
                    "    \"name\": \"System\",\n" +
                    "    \"component\": \"LAYOUT\",\n" +
                    "    \"redirect\": \"/system/account\",\n" +
                    "    \"meta\": {\n" +
                    "      \"icon\": \"ion:settings-outline\",\n" +
                    "      \"title\": \"routes.demo.system.moduleName\"\n" +
                    "    },\n" +
                    "    \"children\": [\n" +
                    "      {\n" +
                    "        \"path\": \"account\",\n" +
                    "        \"name\": \"AccountManagement\",\n" +
                    "        \"meta\": {\n" +
                    "          \"title\": \"routes.demo.system.account\",\n" +
                    "          \"ignoreKeepAlive\": true\n" +
                    "        },\n" +
                    "        \"component\": \"/demo/system/account/index\"\n" +
                    "      },\n" +
                    "      {\n" +
                    "        \"path\": \"account_detail/:id\",\n" +
                    "        \"name\": \"AccountDetail\",\n" +
                    "        \"meta\": {\n" +
                    "          \"hideMenu\": true,\n" +
                    "          \"title\": \"routes.demo.system.account_detail\",\n" +
                    "          \"ignoreKeepAlive\": true,\n" +
                    "          \"showMenu\": false,\n" +
                    "          \"currentActiveMenu\": \"/system/account\"\n" +
                    "        },\n" +
                    "        \"component\": \"/demo/system/account/AccountDetail\"\n" +
                    "      },\n" +
                    "      {\n" +
                    "        \"path\": \"role\",\n" +
                    "        \"name\": \"RoleManagement\",\n" +
                    "        \"meta\": {\n" +
                    "          \"title\": \"routes.demo.system.role\",\n" +
                    "          \"ignoreKeepAlive\": true\n" +
                    "        },\n" +
                    "        \"component\": \"/demo/system/role/index\"\n" +
                    "      },\n" +
                    "      {\n" +
                    "        \"path\": \"menu\",\n" +
                    "        \"name\": \"MenuManagement\",\n" +
                    "        \"meta\": {\n" +
                    "          \"title\": \"routes.demo.system.menu\",\n" +
                    "          \"ignoreKeepAlive\": true\n" +
                    "        },\n" +
                    "        \"component\": \"/demo/system/menu/index\"\n" +
                    "      },\n" +
                    "      {\n" +
                    "        \"path\": \"dept\",\n" +
                    "        \"name\": \"DeptManagement\",\n" +
                    "        \"meta\": {\n" +
                    "          \"title\": \"routes.demo.system.dept\",\n" +
                    "          \"ignoreKeepAlive\": true\n" +
                    "        },\n" +
                    "        \"component\": \"/demo/system/dept/index\"\n" +
                    "      },\n" +
                    "      {\n" +
                    "        \"path\": \"changePassword\",\n" +
                    "        \"name\": \"ChangePassword\",\n" +
                    "        \"meta\": {\n" +
                    "          \"title\": \"routes.demo.system.password\",\n" +
                    "          \"ignoreKeepAlive\": true\n" +
                    "        },\n" +
                    "        \"component\": \"/demo/system/password/index\"\n" +
                    "      }\n" +
                    "    ]\n" +
                    "  },\n" +
                    "  {\n" +
                    "    \"path\": \"/link\",\n" +
                    "    \"name\": \"Link\",\n" +
                    "    \"component\": \"LAYOUT\",\n" +
                    "    \"meta\": {\n" +
                    "      \"icon\": \"ion:tv-outline\",\n" +
                    "      \"title\": \"routes.demo.iframe.frame\"\n" +
                    "    },\n" +
                    "    \"children\": [\n" +
                    "      {\n" +
                    "        \"path\": \"doc\",\n" +
                    "        \"name\": \"Doc\",\n" +
                    "        \"meta\": {\n" +
                    "          \"title\": \"routes.demo.iframe.doc\",\n" +
                    "          \"frameSrc\": \"https://vvbin.cn/doc-next/\"\n" +
                    "        }\n" +
                    "      },\n" +
                    "      {\n" +
                    "        \"path\": \"https://vvbin.cn/doc-next/\",\n" +
                    "        \"name\": \"DocExternal\",\n" +
                    "        \"component\": \"LAYOUT\",\n" +
                    "        \"meta\": {\n" +
                    "          \"title\": \"routes.demo.iframe.docExternal\"\n" +
                    "        }\n" +
                    "      }\n" +
                    "    ]\n" +
                    "  }\n" +
                    "]\n";

        return ResponseEntity.status(HttpStatus.OK).contentType(MediaType.APPLICATION_JSON).body(menu);
    }
}
