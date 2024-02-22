#!/user/bin/env groovy
import com.example

def call() {
    return new Docker(this).dockerLogin()
}
