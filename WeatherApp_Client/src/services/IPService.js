export default{

    getIPAddress(){
        return fetch('https://api.ipify.org/?format=json');
    }
}
