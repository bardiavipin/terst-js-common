define("js-module@1.0.0/logger.es", ['exports', './utils/log.es', 'jquery'], function (exports, _log, _jquery) {
	'use strict';

	Object.defineProperty(exports, "__esModule", {
		value: true
	});
	exports.$ = undefined;

	var _log2 = _interopRequireDefault(_log);

	var _jquery2 = _interopRequireDefault(_jquery);

	function _interopRequireDefault(obj) {
		return obj && obj.__esModule ? obj : {
			default: obj
		};
	}

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

	exports.$ = _jquery2.default;

	var Logger = function () {
		function Logger() {
			var shellPrompt = arguments.length <= 0 || arguments[0] === undefined ? '|> ' : arguments[0];

			_classCallCheck(this, Logger);

			this.shellPrompt = shellPrompt;
		}

		_createClass(Logger, [{
			key: 'log',
			value: function log(msg) {

				var shellMessage = this.shellPrompt + ' ' + msg;
				(0, _log2.default)(shellMessage);
			}
		}]);

		return Logger;
	}();

	exports.default = Logger;
});
//# sourceMappingURL=logger.es.js.map