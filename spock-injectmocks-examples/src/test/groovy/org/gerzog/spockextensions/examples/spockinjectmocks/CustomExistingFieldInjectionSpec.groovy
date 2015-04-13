/**
 * Copyright 2015 Nikolay Lagutko <nikolay.lagutko@mail.com>
 *
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *
 *     http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */
package org.gerzog.spockextensions.examples.spockinjectmocks

import org.apache.commons.lang3.reflect.FieldUtils
import org.gerzog.spock.injectmock.api.Injectable
import org.gerzog.spockextensions.examples.base.repository.IUserRepository
import org.gerzog.spockextensions.examples.base.repository.impl.UserRepositoryImpl
import org.gerzog.spockextensions.examples.base.service.impl.UserServiceImpl

import spock.lang.Specification
import spock.lang.Subject

/**
 * @author Nikolay Lagutko (nikolay.lagutko@mail.com)
 *
 */
class CustomExistingFieldInjectionSpec extends Specification {

	@Subject
	def userService = new UserServiceImpl()

	@Injectable
	IUserRepository userRepository = new UserRepositoryImpl()

	def "check user repository injected"() {
		expect:
		FieldUtils.readDeclaredField(userService, 'userRepository', true) != null
	}

	def "check injected value same as field"() {
		expect:
		FieldUtils.readDeclaredField(userService, 'userRepository', true) == userRepository
	}

	def "check mocking result value"() {
		when:
		def result = userService.findUser()

		then:
		result == null
	}
}
