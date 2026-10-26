package id.my.tudemaha.lobos.domain.model

class EmailNotVerifiedException(
    message: String = "Email not verified"
): Exception(message)