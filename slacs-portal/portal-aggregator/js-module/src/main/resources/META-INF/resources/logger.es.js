//import MainLogger from './utils/log.es';
class Logger {
	constructor(shellPrompt = '|> ') {
		this.shellPrompt = shellPrompt;
	}

	log(msg) {

		let shellMessage = `${this.shellPrompt} ${msg}`;
        //let logMe = new MainLogger();
        //logMe.log(shellMessage);
        console.log("vipin");
        console.log(`${msg} :: `);

	}
}

export default Logger;