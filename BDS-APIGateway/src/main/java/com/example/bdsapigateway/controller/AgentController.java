package com.example.bdsapigateway.controller;

import com.example.bdsapigateway.modelDTO.Agent;
import com.example.bdsapigateway.modelDTO.ResponseObject;
import com.example.bdsapigateway.service.agent.AgentGatewayService;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiResponse;
import io.swagger.annotations.ApiResponses;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

@RestController
@RequestMapping("/api-gateway")
@Api(value="onlinestore", description="API Agent")
public class AgentController {

    @Autowired
    private AgentGatewayService agentGatewayService;


    @ApiOperation(value = "Lấy ra tất cả Agent",response = Agent.class)
    @ApiResponses(value = {
            @ApiResponse(code = 200, message = "Trả ra dữ liệu thành công!"),
            @ApiResponse(code = 401, message = "Xác thực thất bại!"),
            @ApiResponse(code = 403, message = "Cố tình truy cập trái phép!"),
            @ApiResponse(code = 404, message = "Không tồn tại!")
    }
    )
    @GetMapping("agents")
    private Flux<Agent> findAllCustomer(){
//        Flux<Agent> listAgent = agentGatewayService.findAllAgent();
//        if(listAgent != null){
//            return ResponseEntity.status(HttpStatus.OK).body(
//                    new ResponseObject("OK","Trả dữ liệu thành công!", listAgent.publish())
//            );
//        }
//        return ResponseEntity.status(HttpStatus.NOT_FOUND).body(
//                new ResponseObject("Not Found","Agent không có dữ liệu!", listAgent)
//        );
        return agentGatewayService.findAllAgent();
    }


    @ApiOperation(value = "Tìm Agent theo id",response = Agent.class)
    @ApiResponses(value = {
            @ApiResponse(code = 200, message = "Trả ra dữ liệu thành công!"),
            @ApiResponse(code = 401, message = "Xác thực thất bại!"),
            @ApiResponse(code = 403, message = "Cố tình truy cập trái phép!"),
            @ApiResponse(code = 404, message = "Không tồn tại!")
    }
    )
    @GetMapping("agents/name/{id}")
    public ResponseEntity<?> findByLastName(@PathVariable("id") Long id) {
        Agent agent = agentGatewayService.findByAgentId(id).block();
        if(agent != null){
            return ResponseEntity.status(HttpStatus.OK).body(
                    new ResponseObject("OK","Trả dữ liệu thành công!", agent)
            );
        }
        return ResponseEntity.status(HttpStatus.NOT_FOUND).body(
                new ResponseObject("Not Found","Agent không tồn tại!", agent)
        );
    }

}
