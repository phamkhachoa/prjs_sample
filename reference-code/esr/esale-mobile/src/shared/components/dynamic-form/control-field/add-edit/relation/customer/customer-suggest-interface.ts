
/**
 * Define customer suggest view
 */
export interface ICustomerSuggestionsProps {
  invisibleLabel?: boolean, // hiden label
  typeSearch: number, // type search (SINGLE or MULTI)
  fieldLabel: string, // label of field
  fields?: any,// fields data relation
  fieldInfo:any// fieldInfo relation
  isError?: boolean,// set background error
  initData?: CustomerSuggest[],// initial data
  isRequire?: boolean,
  hiddenSelectedData?: boolean,// hidden data selected
  listIdChoice?: number[],//selected ID
  updateStateElement: (searchValue: any) => void; // callback when change status control
  exportError?: (err: any) => void;
}

/**
 * Define values of customer
 */
export interface CustomerSuggest {
  customerId: number,// data in database mapping
  customerName: string,// data in database mapping
  parentCustomerName: string,// data in database mapping
  address: string// data in database mapping
  customerData?:any
}


/**
 * Define structure values of data api
 */
export interface CustomersSuggestionResponse {
  data: { customers: CustomerSuggest[] };// list data form response
  status: number;// status off response
}

/**
 * Define structure values of data api
 */
export interface SuggestionsChoiceResponse {
  data: number[];// list data form response
  status: number;// status off response
}

/**
 * Define structure values of data api
 */
export interface GetCustomersResponse {
  data: {
    totalRecords: number,
    customers: Customer[]
  };// list data form response
  status: number;// status off response
}

/**
 * Define structure values of data api
 */
export interface CustomFieldsInfoResponse {
  data: { customFieldsInfo: any[] };// list data form response
  status: number;// status off response
}

/**
 * Define values of customer
 */
export interface Customer {
  customerId: number,// data in database mapping
  customerName: string,// data in database mapping
  customerParent: {// data in database mapping
    pathTreeId: string,
    pathTreeName: string[]
  },
  customerAddress: {// data in database mapping
    zipCode: string,
    addressName: string,
    buildingName: string,
    address: string
  }
}