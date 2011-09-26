package frontlinesms2.status

import frontlinesms2.*

class StatusPage extends geb.Page {
	static url = 'status'
	static at = {
		title.startsWith('Status')
	}
	static content = {
		statusButton { $('#update-chart') }
		
		detectModems { $('.button', href:'/frontlinesms2/status/detectDevices') }
		detectedDevicesSection { $('div#device-detection') }
		noDevicesDetectedNotification { detectedDevicesSection.find('p') }
		detectedDevicesTable(required:false) { detectedDevicesSection.find('table') }
	}
}