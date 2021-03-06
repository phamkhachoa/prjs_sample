export const D_DETAIL_HISTORY_RESPONSE = {
  fieldInfo: [
    {
      fieldId: 1,
      fieldName: "product_name",
      fieldLabel: '{"ja_jp": "カテゴリ名","en_us": "product name","zh_cn": ""}',
      fieldType: 1,
      fieldOrder: 1,
    },
    {
      fieldId: 2,
      fieldName: "memo",
      fieldLabel: '{"ja_jp": "メモ","en_us": "memo","zh_cn": ""}',
      fieldType: 1,
      fieldOrder: 1,
    },
    {
      fieldId: 3,
      fieldName: "task_name",
      fieldLabel: '{"ja_jp": "タスク名","en_us": "task name","zh_cn": ""}',
      fieldType: 1,
      fieldOrder: 1,
    },
    {
      fieldId: 4,
      fieldName: "milestone_name",
      fieldLabel: '{"ja_jp": "タスク名","en_us": "milestone name","zh_cn": ""}',
      fieldType: 1,
      fieldOrder: 1,
    },
    {
      fieldId: 5,
      fieldName: "business_card_name",
      fieldLabel:
        '{"ja_jp": "名刺名","en_us": "business card name","zh_cn": ""}',
      fieldType: 1,
      fieldOrder: 1,
    },

    {
      fieldId: 6,
      fieldName: "customer_name",
      fieldLabel: '{"ja_jp": "顧客名","en_us": "customer name","zh_cn": ""}',
      fieldType: 1,
      fieldOrder: 1,
    },
  ],
  businessCardHistories: [
    {
      updatedDate: "2019-05-11 12:00",
      updatedUserId: 12,
      updatedUserName: "山田",
      updatedUserImage:
        "https://cdn4.iconfinder.com/data/icons/avatars-21/512/avatar-circle-human-male-3-512.png",
      contentChange: '{"business_card_name":{"old":"タスクC","new":"タスクB"}}',
      businessCardHistoryId: 1,
      businessCardId: 1,
      updatedUserPhotoName: "string",
      updatedUserPhotoPath:
        "https://cdn4.iconfinder.com/data/icons/avatars-21/512/avatar-circle-human-male-3-512.png",
      firstName: "営業",
      lastName: "太郎",
      companyName: "Toyota",
      mergedBusinessCards: [
        {
          businessCardId: 1,
          alternativeCustomerName: "D_x",
          companyName: "Toyota",
          firstName: "D_営業",
          lastName: "D_太郎",
          firstNameKana: "D_営業",
          lastNameKana: "D_太郎",
          position: "代表取締役",
          departmentName: "部門A",
          zipCode: "270-0000",
          address: "Tokyo",
          building: "Building A",
          emailAddress: "email@gmail.com",
          phoneNumber: "012-1234-1234",
          mobileNumber: "012-1111-1111",
          lastContactDate: "2020/03/29 10:11",
          isWorking: "D_x",
          memo: "メモA",
          fax: "012-1234-4321",
          url: "https://url.com",
        },
        {
          businessCardId: 2,
          alternativeCustomerName: "D_x",
          companyName: "Toyota",
          firstName: "D_営業",
          lastName: "D_太郎",
          firstNameKana: "D_営業",
          lastNameKana: "D_太郎",
          position: "代表取締役",
          departmentName: "部門A",
          zipCode: "270-0000",
          address: "Tokyo",
          building: "Building A",
          emailAddress: "email@gmail.com",
          phoneNumber: "012-1234-1234",
          mobileNumber: "012-1111-1111",
          lastContactDate: "2020/03/29 10:11",
          isWorking: "D_x",
          memo: "メモA",
          fax: "012-1234-4321",
          url: "https://url.com",
        },
        {
          businessCardId: 3,
          alternativeCustomerName: "D_x",
          companyName: "Toyota",
          firstName: "D_営業",
          lastName: "D_太郎",
          firstNameKana: "D_営業",
          lastNameKana: "D_太郎",
          position: "代表取締役",
          departmentName: "部門A",
          zipCode: "270-0000",
          address: "Tokyo",
          building: "Building A",
          emailAddress: "email@gmail.com",
          phoneNumber: "012-1234-1234",
          mobileNumber: "012-1111-1111",
          lastContactDate: "2020/03/29 10:11",
          isWorking: "D_x",
          memo: "メモA",
          fax: "012-1234-4321",
          url: "https://url.com",
        },
      ],
    },
    {
      businessCardHistoryId: 2,
      updatedDate: "2019-05-10 22:00",
      updatedUserId: 12,
      updatedUserName: "山田",
      updatedUserImage:
        "https://cdn4.iconfinder.com/data/icons/avatars-21/512/avatar-circle-human-male-3-512.png",
      contentChange:
        '{"business_card_name":{"old":"タスクC","new":"タスクB"},"memo":{"old":"なし","new":"メモ B"}}',
      reasonEdit: "変更理由A",
      firstName: "営業",
      lastName: "太郎",
      companyName: "Toyota",
      mergedBusinessCards: [
        {
          businessCardId: 1,
          alternativeCustomerName: "D_x",
          companyName: "Toyota",
          firstName: "D_営業",
          lastName: "D_太郎",
          firstNameKana: "D_営業",
          lastNameKana: "D_太郎",
          position: "代表取締役",
          departmentName: "部門A",
          zipCode: "270-0000",
          address: "Tokyo",
          building: "Building A",
          emailAddress: "email@gmail.com",
          phoneNumber: "012-1234-1234",
          mobileNumber: "012-1111-1111",
          lastContactDate: "2020/03/29 10:11",
          isWorking: "D_x",
          memo: "メモA",
          fax: "012-1234-4321",
          url: "https://url.com",
        },
      ],
    },
    {
      businessCardHistoryId: 3,
      updatedDate: "2019-05-10 21:00",
      updatedUserId: 13,
      updatedUserName: "茂木康汰",
      updatedUserImage:
        "https://cdn4.iconfinder.com/data/icons/avatars-21/512/avatar-circle-human-male-3-512.png",
      contentChange:
        '{"business_card_name":{"old":"タスクB","new":"タスクCCCCCCC"},"memo":{"old":"なしB","new":"なし"}}',
      reasonEdit: "変更理由A",
      firstName: "営業",
      lastName: "太郎",
      companyName: "Toyota",
    },
    {
      businessCardHistoryId: 4,
      updatedDate: "2019/05/10 20:50",
      updatedUserId: 13,
      updatedUserName: "茂木康汰",
      updatedUserImage:
        "https://cdn4.iconfinder.com/data/icons/avatars-21/512/avatar-circle-human-male-3-512.png",
      contentChange:
        '{"business_card_name":{"old":"タスクA","new":"タスクB"},"memo":{"old":"なしB","new":"なし"}}',
      reasonEdit: "変更理由A",
      firstName: "営業",
      lastName: "太郎",
      companyName: "Toyota",
    },
    {
      businessCardHistoryId: 5,
      updatedDate: "2019/05/10 20:45",
      updatedUserId: 13,
      updatedUserName: "茂木康汰",
      updatedUserImage:
        "https://cdn4.iconfinder.com/data/icons/avatars-21/512/avatar-circle-human-male-3-512.png",
      contentChange:
        '{"business_card_name":{"old":"タスクA","new":"タスクB"},"memo":{"old":"なしB","new":"なし"}}',
      reasonEdit: "変更理由A",
      firstName: "営業",
      lastName: "太郎",
      companyName: "Toyota",
    },
  ],
};

export const D_BUSINESS_CARD_DETAIL = {
  data: {
    fieldInfo: [
      {
        fieldId: 1,
        fieldName: "businessCardId",
      },
    ],
    businessCardDetail: {
      businessCardId: 1,
      businessCardData: {
        businessCardId: 1,
        customerName: "顧客A",
        businessCardImageName: "NameX1",
        businessCardNameKana: "",
        position: 1,
        departmentName: "",
        address: "",
        emailAddress: "",
        phoneNumber: "",
        mobileNumber: "",
        businessCardReceives: [
          {
            employeeId: 123,
            receiveDate: "2019/02/22 09:30:00",
            receivedLastContactDate: "2019/02/15 10:20:12",
            activityId: 1001,
            employeeSurname: "か",
            employeeName: "なな",
            employeePhoto: {
              filePath: "",
              fileName: "",
            },
          },
          {
            employeeId: 124,
            receiveDate: "2019/02/22 09:30:00",
            receivedLastContactDate: "2019/02/15 10:20:12",
            activityId: 1001,
            employeeSurname: "か",
            employeeName: "なな",
            employeePhoto: {
              filePath: "",
              fileName: "",
            },
          },
          {
            employeeId: 125,
            receiveDate: "2019/02/12 09:30:00",
            receivedLastContactDate: "2019/02/15 10:20:12",
            activityId: 1002,
            employeeSurname: "か",
            employeeName: "なな",
            employeePhoto: {
              filePath: "",
              fileName: "",
            },
          },
          {
            employeeId: 126,
            receiveDate: "2019/02/12 09:30:00",
            receivedLastContactDate: "2019/02/15 10:20:12",
            activityId: 1003,
            employeeSurname: "か",
            employeeName: "なな",
            employeePhoto: {
              filePath: "",
              fileName: "",
            },
          },
          {
            employeeId: 126,
            receiveDate: "2019/02/12 09:30:00",
            receivedLastContactDate: "2019/02/15 10:20:12",
            activityId: 1003,
            employeeSurname: "か",
            employeeName: "なな",
            employeePhoto: {
              filePath: "",
              fileName: "",
            },
          },
          {
            employeeId: 127,
            receiveDate: "2019/02/12 09:30:00",
            receivedLastContactDate: "2019/02/16 10:20:12",
            activityId: 1004,
            employeeSurname: "か",
            employeeName: "なな",
            employeePhoto: {
              filePath: "",
              fileName: "",
            },
          },
          {
            employeeId: 128,
            receiveDate: "2019/02/12 09:30:00",
            receivedLastContactDate: "2019/01/15 10:20:12",
            activityId: 1004,
            employeeSurname: "か",
            employeeName: "なな",
            employeePhoto: {
              filePath: "",
              fileName: "",
            },
          },
        ],
        lastContactDate: "2020/12/12",
        memo: "",
        createdDate: "2020/12/12",
        updatedDate: "2020/12/13",
      },
      customerName: "顧客A",
      businessCardImagePath:
        "https://image.shutterstock.com/image-photo/white-transparent-leaf-on-mirror-260nw-1029171697.jpg",
      businessCardImageName: "NameX1",
      businessCardReceives: [
        {
          employeeId: 123,
          receiveDate: "2019/02/22 09:30:00",
          receivedLastContactDate: "2019/02/15 10:20:12",
          activityId: 1001,
          employeeSurname: "か",
          employeeName: "なな",
          employeePhoto: {
            filePath: "",
            fileName: "",
          },
        },
        {
          employeeId: 124,
          receiveDate: "2019/02/22 09:30:00",
          receivedLastContactDate: "2019/02/15 10:20:12",
          activityId: 1001,
          employeeSurname: "か",
          employeeName: "なな",
          employeePhoto: {
            filePath: "",
            fileName: "",
          },
        },
        {
          employeeId: 125,
          receiveDate: "2019/02/12 09:30:00",
          receivedLastContactDate: "2019/02/15 10:20:12",
          activityId: 1002,
          employeeSurname: "か",
          employeeName: "なな",
          employeePhoto: {
            filePath: "",
            fileName: "",
          },
        },
        {
          employeeId: 126,
          receiveDate: "2019/02/12 09:30:00",
          receivedLastContactDate: "2019/02/15 10:20:12",
          activityId: 1003,
          employeeSurname: "か",
          employeeName: "なな",
          employeePhoto: {
            filePath: "",
            fileName: "",
          },
        },
        {
          employeeId: 126,
          receiveDate: "2019/02/12 09:30:00",
          receivedLastContactDate: "2019/02/15 10:20:12",
          activityId: 1003,
          employeeSurname: "か",
          employeeName: "なな",
          employeePhoto: {
            filePath: "",
            fileName: "",
          },
        },
        {
          employeeId: 127,
          receiveDate: "2019/02/12 09:30:00",
          receivedLastContactDate: "2019/02/16 10:20:12",
          activityId: 1004,
          employeeSurname: "か",
          employeeName: "なな",
          employeePhoto: {
            filePath: "",
            fileName: "",
          },
        },
        {
          employeeId: 128,
          receiveDate: "2019/02/12 09:30:00",
          receivedLastContactDate: "2019/01/15 10:20:12",
          activityId: 1004,
          employeeSurname: "か",
          employeeName: "なな",
          employeePhoto: {
            filePath: "",
            fileName: "",
          },
        },
      ],
      hasActivity: 1,
      hasFollow: 1,
      customerId: 1,
      departmentName: "経理部",
      position: "代表取締役",
      firstName: "名刺",
      lastName: "太郎",
      alternativeCustomerName: "代替名A",
      lastContactDate: "2019/02/15",
    },
    businessCardHistoryDetail: {
      customerId: 101,
      customerName: "名A",
      businessCardsReceivesHistories: [
        {
          employeeId: 123,
          receiveDate: "2019/02/22 09:30:00",
          receivedLastContactDate: "2019/02/25 10:20:12",
          activityId: 1005,
          employeeSurname: "か",
          employeeName: "なな",
        },
      ],

      businessCardId: 1,
      departmentName: "departmentName",
      position: "代表取締役",
      firstName: "D_営業",
      lastName: "D_太郎",
      businessCardImagePath: "",
      businessCardImageName: "XX1",
    },
    timelines: {},
    tabsInfo: [],
    activityHistories: [],
    tradingProduct: {
      tradingProductBudges: 1,
      tradingProductData: [],
    },
    calendar: {
      calendarBudges: 2,
      calendarData: [],
    },
    histories: [],
  },
};
