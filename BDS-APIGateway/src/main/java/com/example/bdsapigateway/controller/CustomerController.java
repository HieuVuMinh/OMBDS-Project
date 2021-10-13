package com.example.bdsapigateway.controller;

import com.example.bdsapigateway.modelDTO.Agent;
import com.example.bdsapigateway.modelDTO.Customer;
import com.example.bdsapigateway.service.agent.AgentGatewayService;
import com.example.bdsapigateway.service.customer.CustomerGatewayService;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiResponse;
import io.swagger.annotations.ApiResponses;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

@RestController
@RequestMapping("api/v1")
@Api(value="onlinestore", description="API Customer")
public class CustomerController {

    @Autowired
    private CustomerGatewayService customerGatewayService;

    @Autowired
    private AgentGatewayService agentGatewayService;


    @ApiOperation(value = "Tìm Tất cả customer",response = Customer.class)
    @ApiResponses(value = {
            @ApiResponse(code = 200, message = "Trả ra dữ liệu thành công!"),
            @ApiResponse(code = 401, message = "Xác thực thất bại!"),
            @ApiResponse(code = 403, message = "Cố tình truy cập trái phép!"),
            @ApiResponse(code = 404, message = "Không tồn tại!")
    }
    )
    @GetMapping("/customers")
    private Flux<Customer> findAllCustomer(){
        return customerGatewayService.findAllCustomer();
    }


    @ApiOperation(value = "Tìm customer theo agent id",response = Customer.class)
    @ApiResponses(value = {
            @ApiResponse(code = 200, message = "Trả ra dữ liệu thành công!"),
            @ApiResponse(code = 401, message = "Xác thực thất bại!"),
            @ApiResponse(code = 403, message = "Cố tình truy cập trái phép!"),
            @ApiResponse(code = 404, message = "Không tồn tại!")
    }
    )
    @GetMapping("/customers/agent-id/{id}")
    public Flux<Customer> findCustomerByAgentId(@PathVariable("name") Long id){
        Agent monoAgent = agentGatewayService.findByAgentId(id).block();

        if(monoAgent != null){
            System.out.println(monoAgent.getId());
            return customerGatewayService.findCustomerByAgentId(monoAgent.getId());
        }
        return null;
    }

    @ApiOperation(value = "Tìm customer chưa có agent support",response = Customer.class)
    @ApiResponses(value = {
            @ApiResponse(code = 200, message = "Trả ra dữ liệu thành công!"),
            @ApiResponse(code = 401, message = "Xác thực thất bại!"),
            @ApiResponse(code = 403, message = "Cố tình truy cập trái phép!"),
            @ApiResponse(code = 404, message = "Không tồn tại!")
    }
    )
    @GetMapping("/customers/agent-exist")
    public Flux<Customer> findCustomerHaveNoAssistance(){
        return customerGatewayService.findCustomerHaveNoAssistance();
    }


    @ApiOperation(value = "Tìm customer theo id",response = Customer.class)
    @ApiResponses(value = {
            @ApiResponse(code = 200, message = "Trả ra dữ liệu thành công!"),
            @ApiResponse(code = 401, message = "Xác thực thất bại!"),
            @ApiResponse(code = 403, message = "Cố tình truy cập trái phép!"),
            @ApiResponse(code = 404, message = "Không tồn tại!")
    }
    )
    @GetMapping("/customer/{id}")
    public Mono<Customer> findCustomerById(String id){
        return customerGatewayService.findCustomerById(id);
    }


    @ApiOperation(value = "Thêm agent support customer",response = Customer.class)
    @ApiResponses(value = {
            @ApiResponse(code = 200, message = "Trả ra dữ liệu thành công!"),
            @ApiResponse(code = 401, message = "Xác thực thất bại!"),
            @ApiResponse(code = 403, message = "Cố tình truy cập trái phép!"),
            @ApiResponse(code = 404, message = "Không tồn tại!")
    }
    )
    @GetMapping("customer/{idCustomer}/assistance/{idAgent}")
    public Mono<Customer> updateCustomerAssistanceByAgent(@PathVariable("idCustomer") String idCustomer,
                                                          @PathVariable("idAgent") Long idAgent){
        Customer customerMono = findCustomerById(idCustomer).block();
        customerMono.setAgentId(idAgent);

        return customerGatewayService.updateCustomerAssistanceByAgent(idCustomer, customerMono);
    }


    @ApiOperation(value = "Thêm customer",response = Customer.class)
    @ApiResponses(value = {
            @ApiResponse(code = 200, message = "Trả ra dữ liệu thành công!"),
            @ApiResponse(code = 401, message = "Xác thực thất bại!"),
            @ApiResponse(code = 403, message = "Cố tình truy cập trái phép!"),
            @ApiResponse(code = 404, message = "Không tồn tại!")
    }
    )
    @PostMapping("/customer")
    public Mono<Customer> createCustomer(@RequestBody Customer customer){
        return customerGatewayService.createCustomer(customer);
    }
}
