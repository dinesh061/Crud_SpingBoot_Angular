


document.addEventListener('DOMContentLoaded', () => {
    const table = document.getElementById('outputTable');
    const headers = Array.from(table.querySelectorAll('thead th'));
    const rows = Array.from(table.querySelectorAll('tbody tr'));
  
    let dragStartIndex = -1;
  
    headers.forEach((header, index) => {
        header.addEventListener('dragstart', (e) => {
            dragStartIndex = index;
            e.dataTransfer.effectAllowed = 'move';
        });
  
        header.addEventListener('dragover', (e) => {
            e.preventDefault(); // Allow drop
        });
  
        header.addEventListener('drop', (e) => {
            e.preventDefault();
            const dragEndIndex = index;
            if (dragStartIndex !== dragEndIndex) {
                swapColumns(dragStartIndex, dragEndIndex);
            }
        });
    });
  
    function swapColumns(fromIndex, toIndex) {
        // Swap headers
        const headersNodes = Array.from(table.querySelectorAll('thead th'));
        const fromHeader = headersNodes[fromIndex];
        const toHeader = headersNodes[toIndex];
        table.querySelector('thead tr').insertBefore(toHeader, fromHeader);
        table.querySelector('thead tr').insertBefore(fromHeader, toHeader.nextSibling);
  
        // Swap column cells
        rows.forEach(row => {
            const cells = Array.from(row.children);
            const fromCell = cells[fromIndex];
            const toCell = cells[toIndex];
            row.insertBefore(toCell, fromCell);
            row.insertBefore(fromCell, toCell.nextSibling);
        });
    }
  });