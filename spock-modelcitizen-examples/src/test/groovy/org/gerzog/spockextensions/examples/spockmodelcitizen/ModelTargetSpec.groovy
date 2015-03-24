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
import org.gerzog.spock.modelcitizen.api.ModelCitizen
import org.gerzog.spockextensions.examples.base.entity.AbstractEntity
import org.gerzog.spockextensions.examples.base.entity.Profile
import org.gerzog.spockextensions.examples.base.entity.User
import org.gerzog.spockextensions.examples.spockmodelcitizen.blueprints.UserBlueprint
import org.gerzog.spockextensions.examples.spockmodelcitizen.blueprints2.ProfileBlueprint

import spock.lang.Specification

/**
 * @author Nikolay Lagutko (nikolay.lagutko@mail.com)
 *
 */
@ModelCitizen(classes = [UserBlueprint, ProfileBlueprint])
class ModelTargetSpec extends Specification {

	@Model(target = User)
	def user

	@Model(target = Profile)
	AbstractEntity profile

	def "verify user was created"() {
		expect:
		user != null
	}

	def "verify profile was created"() {
		expect:
		profile != null
	}

	def "verify user instance of correct type"() {
		expect:
		user instanceof User
	}

	def "verify profile instance of correct type"() {
		expect:
		profile instanceof Profile
	}
}


