import com.sky.BootStrapService

class BootStrap {

    BootStrapService bootStrapService

    def init = { servletContext ->
        bootStrapService.init(servletContext)
    }
    def destroy = {
    }
}
