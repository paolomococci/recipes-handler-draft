/**
 *
 * Copyright 2018 paolo mococci
 *
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *
 * http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 *
 */

package local.example.draft.config

import cz.jirutka.spring.embedmongo.EmbeddedMongoFactoryBean
import org.springframework.context.annotation.Bean
import org.springframework.context.annotation.Configuration
import org.springframework.data.mongodb.core.MongoTemplate
import java.io.IOException

@Configuration
class Config {

    @Bean
    @Throws(IOException::class)
    fun mongodbTemplate(): MongoTemplate {
        val mongodb = EmbeddedMongoFactoryBean()
        mongodb.setBindIp(DB_URL)
        val mongodbClient = mongodb.getObject()
        return MongoTemplate(mongodbClient!!, DB_NAME)
    }

    companion object {

        private val DB_URL = "127.0.0.1"
        private val DB_NAME = "embedded_db"
    }
}
