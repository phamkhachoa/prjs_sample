import {  StyleSheet } from "react-native";
import { theme } from "../../../config/constants";

export const styles = StyleSheet.create({
    container: {
        flex: 1,
        backgroundColor: theme.colors.white,
    },
    containerDropdown: {
        backgroundColor: theme.colors.gray400,
        borderWidth: 1,
        borderColor: theme.colors.gray100,
        borderRadius: theme.space[4],
        marginTop: theme.space[3],
        height: theme.space[12],
        justifyContent: "center",
    },
    viewItemContent: {
        paddingHorizontal: theme.space[4],
        paddingVertical: theme.space[4],
        borderBottomWidth: 1,
        borderBottomColor: theme.colors.gray100,
    },
    viewAddStaff: {
        width: "100%",
        height: theme.space[12],
        borderRadius: theme.space[4],
        borderWidth: 1,
        borderColor: theme.colors.gray100,
        flexDirection: "row",
        alignItems: "center",
        marginTop: theme.space[2],
    },
    viewStaffInfo: {
        width: "100%",
        height: theme.space[13],
        borderRadius: theme.space[4],
        backgroundColor: theme.colors.gray100,
        marginTop: theme.space[2],
        justifyContent: "space-between",
        paddingHorizontal: theme.space[2],
        flexDirection: "row",
        alignItems: "center",
    },
    avarStaff: {
        height: theme.space[8],
        width: theme.space[8],
        marginVertical: theme.space[3],
        marginRight: theme.space[2],
    },
    btnAddFile: {
        flexDirection: "row",
        width: "100%",
        height: theme.space[12],
        borderRadius: theme.space[4],
        borderWidth: 1,
        borderColor: theme.colors.gray100,
        justifyContent: "center",
        alignItems: "center",
        marginTop: theme.space[2],
        borderStyle: "dashed",
    },
    txtAddFile: {
        color: theme.colors.gray,
        fontSize: theme.fontSizes[1],
        marginLeft: theme.space[2],
    },
    txtContentBtn: { color: theme.colors.gray1, fontSize: theme.fontSizes[1] },
    viewRequired: {
        backgroundColor: theme.colors.red500,
        borderRadius: theme.space[1],
        marginLeft: theme.space[5],
        justifyContent: "center",
        alignItems: "center",
        height: 16,
        width: 36,
    },
    txtRequired: {
        color: theme.colors.white,
        fontSize: theme.fontSizes[0],
    },
    viewStatusTask: {
        flexDirection: "row",
        alignItems: "center",
    },
    txtTime: {
        color: theme.colors.gray,
        fontSize: theme.fontSizes[1],
        marginTop: theme.space[3],
    },
    containerItem: {
        width: "100%",
        height: theme.space[11],
        borderRadius: 15,
        backgroundColor: "#E6E6E6",
        flexDirection: "row",
        marginTop: 10,
    },
    txtItem: {
        color: "#333",
        fontSize: 15,
        flex: 3,
        paddingLeft: "5%",
        marginTop: "4%",
    },
    btnItem: { flex: 1, alignItems: "center", justifyContent: "center" },
    appbarTitle: { fontWeight: "normal", color: "#333333" },
    bgGray400: {
        backgroundColor: theme.colors.gray400,
    },
    listFile: { width: "100%" },
    iconRNpicker: { marginRight: theme.space[3] },
    txtMessRequired: {
        textAlign: "center",
        marginVertical: theme.space[2],
        color: "red",
    }
});