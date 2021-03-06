import { StyleSheet } from "react-native";

export const TimelineItem = StyleSheet.create({
  container: {
    width: "100%",
    minHeight: 120,
    padding: "3%",
  },
  topContent: {
    flexDirection: "row",
    width: "100%",
    height: 35,
  },
  topContentInfo: {
    flex: 5,
    flexDirection: "row",
    alignItems: "center",
    paddingRight: '10%'
  },
  topContentInfoImg: { width: 30, height: 30, borderRadius: 15 },
  topContentInfoName: { fontSize: 15, marginLeft: 10, color: "#0F6DB1" },
  topContentDate: {
    flex: 3,
    alignItems: "flex-end",
    paddingTop: 4,
  },
  topContentInfoDate: { fontSize: 10, color: "#959595" },
  topContentDelete: {
    flex: 1,
    alignItems: "center",
  },
  topContentInfoDelete: { width: 13, height: 18 },
  mainContent: { width: "100%", marginTop: 10, paddingLeft: "8%" },
  mainTxt: { letterSpacing: 1, fontSize: 14, lineHeight: 20 },
  mainBtn: {
    width: 120,
    height: 28,
    borderRadius: 10,
    borderWidth: 1,
    borderColor: "#E4E4E4",
    alignItems: "center",
    justifyContent: "center",
    marginTop: 12,
  },
  mainBtnTxt: {
    color: "#666666",
    fontSize: 14,
  },
  btnReaction: {
    borderColor: "#E3E3E3",
    borderRadius: 8,
    borderWidth: 1,
    width: 48,
    height: 28,
    flexDirection: "row",
    justifyContent: "center",
    alignItems: "center",
    marginRight: 8,
  },
  btnReactionTxt: {
    fontSize: 12,
    marginHorizontal: 1,
    color: "#666666",
  },
  btnReactionIcon: {
    fontSize: 14,
    marginHorizontal: 1,
  },
  containerReaction: { width: "100%", marginTop: 10 },
  containerOptions: {
    flexDirection: "row",
    height: 60,
    width: "100%",
    borderBottomWidth: 1,
    borderTopWidth: 1,
    borderColor: "#E3E3E3",
  },
  file: {
    width: "90%",
    height: 38,
    backgroundColor: "#F5F5F5",
    flexDirection: "row",
    borderRadius: 10,
    alignItems: "center",
    justifyContent: "flex-start",
    marginTop: 10,
  },
  fileIcon: {
    marginLeft: 10,
    width: 20,
  },
  fileTxt: {
    color: "#666666",
    fontSize: 14,
    marginLeft: 8,
  },
  containerShare: {
    width: "90%",
    flexDirection: "row",
    borderColor: "#E5E5E5",
    borderWidth: 1,
    borderRadius: 10,
    minHeight: 100,
    paddingVertical: 15,
    marginTop: 10,
  },
  containerShareLeft: { flex: 1, alignItems: "center" },
  shareLeftIcon: { width: 12, height: 12 },
  shareLine: {
    width: 4,
    backgroundColor: "#999999",
    flex: 1,
    marginTop: 5,
  },
  containerShareRight: { flex: 7 },
  shareInfo: { flexDirection: "row" },
  shareInfoAvt: { width: 24, height: 24, borderRadius: 12 },
  shareInfoName: { fontSize: 15, marginLeft: 10, color: "#0F6DB1", paddingRight: 30 },
  shareContent: {
    letterSpacing: 1,
    lineHeight: 20,
    marginTop: 6,
    paddingRight: "2%",
  },
  boxShareContent: { minHeight: 50, maxHeight: 70 },
  option: { marginTop: 20 },
});
