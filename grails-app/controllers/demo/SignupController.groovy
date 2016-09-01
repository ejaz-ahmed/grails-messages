package demo


import grails.rest.*
import grails.converters.*
import org.springframework.http.HttpStatus


class SignupController {
    static responseFormats = ['json']

    def signup() {
        User user = new User()
        user.username = (String)request.JSON.username
        user.save(flush: true)
        if(user.hasErrors()) {
            response.status = 400
            render user.errors.allErrors as JSON
        } else {
            render status: HttpStatus.CREATED
        }

    }
}
