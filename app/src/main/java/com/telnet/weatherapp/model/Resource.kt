package com.telnet.domain.model

sealed class Resource<T>(val data: T?, val message: String?,val code : StatusCode? ) {
    class Success<T>(data: T,  code : StatusCode = StatusCode.OK , message: String = "") : Resource<T>(data, message,code)
    class Loading<T> : Resource<T>(null , null,null)
    class Error<T>(message: String,val errors: HashMap<String, String>?=null, code : StatusCode? = StatusCode.Error) : Resource<T>(null, message,code)
}

enum class StatusCode(val code: Int) {
    OK(200),
    Created(201),
    MisdirectedRequest(421),
    Accepted(202),
    UnprocessableEntity(422),
    BadRequest(400),
    Unauthorized(401),
    UnauthorizedEndPoint(511),
    Forbidden(403),
    NotFound(404),
    Error(500),
    AuthorizedToken(601),
    Empty(602),

}