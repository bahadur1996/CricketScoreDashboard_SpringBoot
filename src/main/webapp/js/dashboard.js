function getItems(params) {
    let url = "http://localhost:8080/rest/v1/item?limit="+params.data.limit+"&offset="+params.data.offset;

    if(params.data.search){
        url+="&search="+params.data.search;
    }

    $.ajax({
        type: "GET",
        url: url,
        success: function (data) {
            params.success({
                "rows": data,
                "total": data.length
            },null,{});
        },
        error: function (er) {
            params.error(er);
        }
    });
}