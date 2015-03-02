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
import org.gerzog.spock.injectmock.api.InjectMock
import org.gerzog.spockextensions.examples.base.entity.User
import org.gerzog.spockextensions.examples.base.repository.IUserRepository
import org.gerzog.spockextensions.examples.base.service.impl.UserServiceImpl

import spock.lang.Specification
import spock.lang.Subject

/**
 * @author Nikolay Lagutko (nikolay.lagutko@mail.com)
 *
 */
class MockFieldInjectionSpec extends Specification {

	@Subject
	def userService = new UserServiceImpl()

	@InjectMock
	IUserRepository userRepository

	def "check user repository injected"() {
		expect:
		FieldUtils.readDeclaredField(userService, 'userRepository', true) != null
	}

	def "check mocking ability"() {
		when:
		userService.findUser()

		then:
		1 * userRepository.findUser()
	}

	def "check mocking result value"() {
		setup:
		def user = new User()
		userRepository.findUser() >> user

		when:
		def result = userService.findUser()

		then:
		user == result
	}
}
