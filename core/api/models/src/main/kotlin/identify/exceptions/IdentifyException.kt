package identify.exceptions

import com.fasterxml.jackson.annotation.JsonIgnoreProperties

@JsonIgnoreProperties("stack_trace", "cause", "suppressed", "localized_message")
open class IdentifyException: Exception()