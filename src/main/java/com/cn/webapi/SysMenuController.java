package com.cn.webapi;

import com.cn.common.exception.ResponseException;
import com.cn.domain.entity.SysMenu;
import com.cn.domain.entity.SysMenuExample;
import com.cn.page.AjaxResponse;
import com.cn.service.SysMenuService;
import io.swagger.annotations.*;
import org.slf4j.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import java.util.List;


/**
 * REST controller for managing SysMenu.
 * Created by zhoubo on 2016/12/1.
 */
@Api(value = "SysMenu", description = "SysMenu相关api", position = 1)
@RestController
@RequestMapping("/api")
public class SysMenuController {
    private final Logger logger = LoggerFactory.getLogger(this.getClass());
    @Autowired
    private SysMenuService sysMenuService;

    @ApiOperation(value = "创建一个SysMenu", notes = "创建一个SysMenu", position = 1)
    @ApiResponses({@ApiResponse(code = 200, message = "运行结果")})
    @PostMapping("/sysMenus")
    public AjaxResponse<SysMenu> createSysMenu(@ApiParam(hidden = true) String userId,@ApiParam(value = "用户token", required = true) @RequestHeader("token") String token,@RequestBody SysMenu sysMenu){
        try {
            return sysMenuService.save(sysMenu);
        }catch (Exception e){
            logger.error(e.getMessage());
            throw new ResponseException(e.getMessage(), HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }

    @ApiOperation(value = "更新一个SysMenu", notes = "更新一个SysMenu", position = 1)
    @ApiResponses({@ApiResponse(code = 200, message = "运行结果")})
    @PutMapping("/sysMenus")
    public AjaxResponse<SysMenu> updateSysMenu(@ApiParam(hidden = true) String userId,@ApiParam(value = "用户token", required = true) @RequestHeader("token") String token,@RequestBody SysMenu sysMenu){
        try {
            return sysMenuService.save(sysMenu);
        }catch (Exception e){
            logger.error(e.getMessage());
            throw new ResponseException(e.getMessage(), HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }

    @ApiOperation(value = "获得所有的SysMenu", notes = "获得所有的SysMenu", position = 1)
    @ApiResponses({@ApiResponse(code = 200, message = "运行结果")})
    @GetMapping("/sysMenus")
    public AjaxResponse<List<SysMenu>> getAllSysMenu(@ApiParam(hidden = true) String userId,@ApiParam(value = "用户token", required = true) @RequestHeader("token") String token){
        try {
            return sysMenuService.findList(new SysMenuExample());
        }catch (Exception e){
            logger.error(e.getMessage());
            throw new ResponseException(e.getMessage(), HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }

    @ApiOperation(value = "根据id获得SysMenu", notes = "根据id获得SysMenu", position = 1)
    @ApiResponses({@ApiResponse(code = 200, message = "运行结果")})
    @GetMapping("/sysMenus/{id}")
    public AjaxResponse<SysMenu> getSysMenu(@ApiParam(hidden = true) String userId,@ApiParam(value = "用户token", required = true) @RequestHeader("token") String token, @PathVariable java.lang.String id){
        try {
            return sysMenuService.getByPK(id);
        }catch (Exception e){
            logger.error(e.getMessage());
            throw new ResponseException(e.getMessage(), HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }

    @ApiOperation(value = "根据id删除SysMenu", notes = "根据id删除SysMenu", position = 1)
    @ApiResponses({@ApiResponse(code = 200, message = "运行结果")})
    @DeleteMapping("/sysMenus/{id}")
    public AjaxResponse<String> deleteSysMenu(@ApiParam(hidden = true) String userId,@ApiParam(value = "用户token", required = true) @RequestHeader("token") String token, @PathVariable java.lang.String id){
        try {
            return sysMenuService.delete(id);
        }catch (Exception e){
            logger.error(e.getMessage());
            throw new ResponseException(e.getMessage(), HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }
}