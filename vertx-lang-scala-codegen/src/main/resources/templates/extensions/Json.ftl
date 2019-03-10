
  import io.vertx.core.json.{JsonObject => JJsonObject}
  import io.vertx.core.json.{JsonArray => JJsonArray}

  type JsonObject = JJsonObject
  type JsonArray = JJsonArray

  object JsonObject {
    def apply(): JsonObject = new JJsonObject()
    def apply(json: String): JsonObject = new JJsonObject(json)
    def apply(fields: (String, Any)*): JsonObject = {
      val o = new JsonObject()
      fields.foreach {
        case (key, l: Array[_]) => o.put(key, listToJsArr(l))
        case (key, l: Seq[_]) => o.put(key, listToJsArr(l))
        case (key, value) => o.put(key, value)
      }
      o
    }
  }

  object JsonArray {
    def apply(): JsonArray = new JJsonArray()
    def apply(json: String): JsonArray = new JJsonArray(json)
    def apply(fields: Any*): JsonArray = {
      val a = new JsonArray()
      fields.foreach {
        case array: Array[_] => a.add(listToJsArr(array))
        case seq: Seq[_] => a.add(listToJsArr(seq))
        case f => a.add(f)
      }
      a
    }
  }

  private def listToJsArr(a: Seq[_]) = JsonArray(a: _*)
