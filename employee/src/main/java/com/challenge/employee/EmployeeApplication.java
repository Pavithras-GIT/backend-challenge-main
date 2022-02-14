package com.challenge.employee;

import lombok.extern.java.Log;
import org.springframework.beans.factory.BeanFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Configurable;
import org.springframework.boot.ApplicationArguments;
import org.springframework.boot.ApplicationRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Configuration;
import org.springframework.messaging.Message;
import org.springframework.statemachine.ExtendedState;
import org.springframework.statemachine.StateContext;
import org.springframework.statemachine.StateMachine;
import org.springframework.statemachine.config.*;
import org.springframework.statemachine.config.builders.StateMachineConfigurationConfigurer;
import org.springframework.statemachine.config.builders.StateMachineStateConfigurer;
import org.springframework.statemachine.config.builders.StateMachineTransitionConfigurer;
import org.springframework.statemachine.config.model.StateMachineModel;
import org.springframework.statemachine.listener.StateMachineListenerAdapter;
import org.springframework.statemachine.region.Region;
import org.springframework.statemachine.state.PseudoState;
import org.springframework.statemachine.state.RegionState;
import org.springframework.statemachine.state.State;
import org.springframework.statemachine.transition.Transition;
import org.springframework.stereotype.Component;
import reactor.core.publisher.Mono;

import java.util.Collection;
import java.util.UUID;
import java.util.function.Function;

@SpringBootApplication
@EnableStateMachine
public class EmployeeApplication {

    public static void main(String[] args) {
        SpringApplication.run(EmployeeApplication.class, args);
    }

}


@Log
@Configuration
@EnableStateMachineFactory
class SimpleEnumStateMachineConfiguration extends StateMachineConfigurerAdapter <EmployeeStates, EmployeeEvents> {
    @Override
    public void configure(StateMachineTransitionConfigurer<EmployeeStates, EmployeeEvents> transitions) throws Exception {
        transitions.withExternal().source(EmployeeStates.ADDED).target(EmployeeStates.CHECK).event(EmployeeEvents.BEGINCHECK)
                .and()
                .withExternal().source(EmployeeStates.CHECK).target(EmployeeStates.APPROVED).event(EmployeeEvents.APPROVE)
                .and()
                .withExternal().source(EmployeeStates.APPROVED).target(EmployeeStates.CHECK).event(EmployeeEvents.UNAPPROVE)
                .and()
                .withExternal().source(EmployeeStates.APPROVED).target(EmployeeStates.ADDED).event(EmployeeEvents.ACTIVATE);
    }

    @Override
    public void configure(StateMachineStateConfigurer<EmployeeStates, EmployeeEvents> states) throws Exception {
        states.withStates().initial(EmployeeStates.ADDED)
                .state(EmployeeStates.CHECK)
                .state(EmployeeStates.APPROVED)
                .end(EmployeeStates.ACTIVE);
    }
    @Override
    public void configure(StateMachineConfigurationConfigurer<EmployeeStates, EmployeeEvents> config) throws Exception {
        StateMachineListenerAdapter<EmployeeStates, EmployeeEvents> adapter = new StateMachineListenerAdapter<EmployeeStates, EmployeeEvents>(){
            @Override
            public void stateChanged(State<EmployeeStates, EmployeeEvents> from, State<EmployeeStates, EmployeeEvents> to) {
                log.info(String.format("stateChanged (from: %s, to: %s)", from + "", to + ""));
            }
        };
        config.withConfiguration().autoStartup(false).listener(adapter);
    }
}