define("js-module@1.0.0/logger.es", ["exports"], function (exports) {
	"use strict";

	Object.defineProperty(exports, "__esModule", {
		value: true
	});

	function _classCallCheck(instance, Constructor) {
		if (!(instance instanceof Constructor)) {
			throw new TypeError("Cannot call a class as a function");
		}
	}

	var _createClass = function () {
		function defineProperties(target, props) {
			for (var i = 0; i < props.length; i++) {
				var descriptor = props[i];
				descriptor.enumerable = descriptor.enumerable || false;
				descriptor.configurable = true;
				if ("value" in descriptor) descriptor.writable = true;
				Object.defineProperty(target, descriptor.key, descriptor);
			}
		}

		return function (Constructor, protoProps, staticProps) {
			if (protoProps) defineProperties(Constructor.prototype, protoProps);
			if (staticProps) defineProperties(Constructor, staticProps);
			return Constructor;
		};
	}();

	var Logger = function () {
		function Logger() {
			var shellPrompt = arguments.length <= 0 || arguments[0] === undefined ? '|> ' : arguments[0];

			_classCallCheck(this, Logger);

			this.shellPrompt = shellPrompt;
		}

		_createClass(Logger, [{
			key: "log",
			value: function log(msg) {

				var shellMessage = this.shellPrompt + " " + msg;
				//let logMe = new MainLogger();
				//logMe.log(shellMessage);
				console.log("vipin");
				console.log(msg + " :: ");
			}
		}]);

		return Logger;
	}();

	exports.default = Logger;
});
//# sourceMappingURL=logger.es.js.map