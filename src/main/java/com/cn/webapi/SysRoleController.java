package com.cn.webapi;

import com.cn.common.exception.ResponseException;
import com.cn.domain.entity.SysRole;
import com.cn.domain.entity.SysRoleExample;
import com.cn.page.AjaxResponse;
import com.cn.service.SysRoleService;
import io.swagger.annotations.*;
import org.slf4j.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import java.util.List;


/**
 * REST controller for managing SysRole.
 * Created by zhoubo on 2016/12/1.
 */
@Api(value = "SysRole", description = "SysRole相关api", position = 1)
@RestController
@RequestMapping("/api")
public class SysRoleController {
    private final Logger logger = LoggerFactory.getLogger(this.getClass());
    @Autowired
    private SysRoleService sysRoleService;

    @ApiOperation(value = "创建一个SysRole", notes = "创建一个SysRole", position = 1)
    @ApiResponses({@ApiResponse(code = 200, message = "运行结果")})
    @PostMapping("/sysRoles")
    public AjaxResponse<SysRole> createSysRole(@ApiParam(hidden = true) String userId,@ApiParam(value = "用户token", required = true) @RequestHeader("token") String token,@RequestBody SysRole sysRole){
        try {
            return sysRoleService.save(sysRole);
        }catch (Exception e){
            logger.error(e.getMessage());
            throw new ResponseException(e.getMessage(), HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }

    @ApiOperation(value = "更新一个SysRole", notes = "更新一个SysRole", position = 1)
    @ApiResponses({@ApiResponse(code = 200, message = "运行结果")})
    @PutMapping("/sysRoles")
    public AjaxResponse<SysRole> updateSysRole(@ApiParam(hidden = true) String userId,@ApiParam(value = "用户token", required = true) @RequestHeader("token") String token,@RequestBody SysRole sysRole){
        try {
            return sysRoleService.save(sysRole);
        }catch (Exception e){
            logger.error(e.getMessage());
            throw new ResponseException(e.getMessage(), HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }

    @ApiOperation(value = "获得所有的SysRole", notes = "获得所有的SysRole", position = 1)
    @ApiResponses({@ApiResponse(code = 200, message = "运行结果")})
    @GetMapping("/sysRoles")
    public AjaxResponse<List<SysRole>> getAllSysRole(@ApiParam(hidden = true) String userId,@ApiParam(value = "用户token", required = true) @RequestHeader("token") String token){
        try {
            return sysRoleService.findList(new SysRoleExample());
        }catch (Exception e){
            logger.error(e.getMessage());
            throw new ResponseException(e.getMessage(), HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }

    @ApiOperation(value = "根据id获得SysRole", notes = "根据id获得SysRole", position = 1)
    @ApiResponses({@ApiResponse(code = 200, message = "运行结果")})
    @GetMapping("/sysRoles/{id}")
    public AjaxResponse<SysRole> getSysRole(@ApiParam(hidden = true) String userId,@ApiParam(value = "用户token", required = true) @RequestHeader("token") String token, @PathVariable java.lang.String id){
        try {
            return sysRoleService.getByPK(id);
        }catch (Exception e){
            logger.error(e.getMessage());
            throw new ResponseException(e.getMessage(), HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }

    @ApiOperation(value = "根据id删除SysRole", notes = "根据id删除SysRole", position = 1)
    @ApiResponses({@ApiResponse(code = 200, message = "运行结果")})
    @DeleteMapping("/sysRoles/{id}")
    public AjaxResponse<String> deleteSysRole(@ApiParam(hidden = true) String userId,@ApiParam(value = "用户token", required = true) @RequestHeader("token") String token, @PathVariable java.lang.String id){
        try {
            return sysRoleService.delete(id);
        }catch (Exception e){
            logger.error(e.getMessage());
            throw new ResponseException(e.getMessage(), HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }
}