package com.example.crud_spring.helpers;

import lombok.AllArgsConstructor;

/**
 * Create CRUD whit Spring
 *
 * @author Alex T.H.
 * @version v0.0.3
 * @since 21.0.0 2024-08-23
 */
@AllArgsConstructor
public class MessageReponseNotObject extends ApiRestFullResponses {

    private String status;
    private int code;
    private String message;

}
