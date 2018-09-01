/**
 *  Copyright 2015 SmartThings
 *
 *  Licensed under the Apache License, Version 2.0 (the "License"); you may not use this file except
 *  in compliance with the License. You may obtain a copy of the License at:
 *
 *      http://www.apache.org/licenses/LICENSE-2.0
 *
 *  Unless required by applicable law or agreed to in writing, software distributed under the License is distributed
 *  on an "AS IS" BASIS, WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied. See the License
 *  for the specific language governing permissions and limitations under the License.
 *
 */
metadata {
	definition (name: "Simulated Alexa Button", namespace: "bjpierron", author: "bjpierron") {
		capability "Actuator"
		capability "Switch"
		capability "Momentary"
		capability "Sensor"
		capability "Contact Sensor"
	}

	// simulator metadata
	simulator {
		status "open": "contact:open"
		status "closed": "contact:closed"

	}

	// UI tile definitions
	tiles {
		standardTile("switch", "device.switch", width: 2, height: 2, canChangeIcon: true) {
			state "off", label: 'Push', action: "momentary.push", backgroundColor: "#ffffff", nextState: "on"
			state "on", label: 'Push', action: "momentary.push", backgroundColor: "#53a7c0"
		}
		main "switch"
		details "switch"
	}
}

def parse(String description) {
}

def push() {
	sendEvent(name: "switch", value: "on", isStateChange: true, display: false)
	sendEvent(name: "switch", value: "off", isStateChange: true, display: false)	
	sendEvent(name: "contact", value: "open", isStateChange: true)	
	sendEvent(name: "momentary", value: "pushed", isStateChange: true)
}

def on() {
	push()
}

def off() {
	push()
}
