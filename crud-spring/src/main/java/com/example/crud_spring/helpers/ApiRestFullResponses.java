package com.example.crud_spring.helpers;

import lombok.AllArgsConstructor;
import lombok.Data;

/**
 * Create CRUD whit Spring
 *
 * @author Alex T.H.
 * @version v0.0.3
 * @since 21.0.0 2024-08-23
 */
@Data
@AllArgsConstructor
public class ApiRestFullResponses {

    public static ApiRestFullResponses response(String status, int code, Object data){
        return new MessageResponseWhitObject(status, code, data);
    }

    public static ApiRestFullResponses response(String status, int code, String message){
        return new MessageReponseNotObject(status, code, message);
    }
}
