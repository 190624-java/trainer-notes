(function () {
    document.getElementById('body').addEventListener('click', (e) => {
        e.stopPropagation();//this will stop the event from propagating throug the elements
        console.log('Event Information: ');
        console.log(`Event Type: ${e.type}
        Target Element: ${e.srcElement}
        CtrlKey?: ${e.ctrlKey}
        ShiftKey?: ${e.shiftKey}`);
        if(e.ctrlKey){
            document.getElementById('body').style = 'background-color: rgb(233, 133, 172)';
        }
        if(e.shiftKey){
            document.getElementById('body').style = 'background-color: white';
        }
    }, true);

    document.getElementById('container1').addEventListener('click', () => {
        console.log('New York pizza');
    }, true);

    document.getElementById('row1').addEventListener('click', () => {
        console.log('\tis better than');
    }, true);

    document.getElementById('success-btn').addEventListener('click', () => {
        console.log('\t\tChicago pizza');
    }, true);

    document.getElementById('warn-btn').addEventListener('click', () => {
        console.log('\t\tPizzaHut pizza');
    }, true);

    document.getElementById('danger-btn').addEventListener('click', () => {
        console.log('\t\tAny pizza');
    }, true);
})();