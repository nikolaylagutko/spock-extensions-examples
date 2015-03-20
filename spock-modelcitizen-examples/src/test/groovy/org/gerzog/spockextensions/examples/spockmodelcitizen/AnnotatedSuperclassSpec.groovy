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
package org.gerzog.spockextensions.examples.spockmodelcitizen

import org.gerzog.spock.modelcitizen.api.Model
import org.gerzog.spockextensions.examples.base.entity.User
import org.gerzog.spockextensions.examples.spockmodelcitizen.internal.AbstractSpecification

/**
 * @author Nikolay Lagutko (nikolay.lagutko@mail.com)
 *
 */
class AnnotatedSuperclassSpec extends AbstractSpecification {

	@Model
	User injectedField

	User customModelField

	def setup() {
		customModelField = model(User)
	}

	def "verify custom model was created"() {
		expect:
		customModelField != null
	}

	def "verify custom model fields was initialized"() {
		expect:
		customModelField.firstName != null
		customModelField.lastName != null
	}

	def "verify value was injected to @Model field"() {
		expect:
		injectedField != null
	}
}
