package com.hmh;

import org.activiti.engine.HistoryService;
import org.activiti.engine.RepositoryService;
import org.activiti.engine.RuntimeService;
import org.activiti.engine.TaskService;
import org.activiti.engine.repository.Deployment;
import org.activiti.engine.runtime.ProcessInstance;
import org.activiti.engine.task.Task;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import java.util.List;

/**
 * 流程定义的部署
 */
@SpringBootTest
@RunWith(SpringRunner.class)
public class ActivitiDeployment {

    //得到RepositoryService实例
    @Autowired
    private RepositoryService repositoryService;
    //对流程任务进行管理，例如任务提醒、任务完成和创建任务等。
    @Autowired
    private TaskService taskService;
    //对流程的历史数据进行操作，包括查询、删除这些历史数据。
    @Autowired
    private HistoryService historyService;
    //在流程运行时对流程实例进行管理与控制。
    @Autowired
    private RuntimeService runtimeService;

    /**
     * 部署流程定义就是要将上边绘制的图形即流程定义（.bpmn）部署在工作流程引擎 activiti 中
     */
    @Test
    public void activitiDeployment() {

        //进行部署
        Deployment deployment = repositoryService.createDeployment()
                .addClasspathResource("processes/diagram_1.bpmn") //添加bpmn资源
                .addClasspathResource("processes/diagram_1.png") //添加png资源
                .name("请假申请单流程")
                .deploy();//进行部署
        System.out.println("流程定义的部署开始============================");
        //输出部署的一些信息
        System.out.println(deployment.getName());
        System.out.println(deployment.getId());//f7195ec5-ebac-11ec-849f-34e12dfd0328
        System.out.println("流程定义的部署结束============================");
    }
    /**
     * 启动一个流程实例：前提是已经完成流程定义的部署
     */
    @Test
    public void startProcessInstance(){

        //创建流程实例，流程定义的key需要知道
        ProcessInstance processInstance = runtimeService.startProcessInstanceByKey("Process_0qsrs8w");
        System.out.println("创建流程实例开始============================");
        //输出流程实例的相关信息
        System.out.println(processInstance.getDeploymentId());//流程部署的id
        System.out.println(processInstance.getId());//流程实例的id
        System.out.println(processInstance.getActivityId());//活动id
        System.out.println("创建流程实例结束============================");
    }

    /**
     * 查询当前用户的任务列表
     */
    @Test
    public void activitiTaskQuery(){

        //根据流程定义的key，负责人assignee来实现当前用户的任务列表查询
        List<Task> taskList = taskService.createTaskQuery()
                .processDefinitionKey("Process_0qsrs8w")
                .taskAssignee("wangwu")
                .list();

        System.out.println("任务列表的展示开始=========================");
        //任务列表的展示
        for (Task task : taskList){
            System.out.println(task.getName());//任务名称
            System.out.println(task.getAssignee());//任务负责人
            System.out.println(task.getId());//任务id
        }
        System.out.println("任务列表的展示结束=========================");
    }


}